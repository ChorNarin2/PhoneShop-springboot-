package chornarin.com.kh.Phone_Shop.Impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import chornarin.com.kh.Phone_Shop.Dto.PriceDto;
import chornarin.com.kh.Phone_Shop.Dto.ProductImportDto;
import chornarin.com.kh.Phone_Shop.Exception.ResourceNotFoundException;
import chornarin.com.kh.Phone_Shop.Mapper.ProductMapper;
import chornarin.com.kh.Phone_Shop.Repository.ProductImportHistoryRepository;
import chornarin.com.kh.Phone_Shop.Repository.ProductRepository;
import chornarin.com.kh.Phone_Shop.Service.ProductService;
import chornarin.com.kh.Phone_Shop.models.Product;
import chornarin.com.kh.Phone_Shop.models.ProductImportHistory;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductImportHistoryRepository productImportHistoryRepository;
    private final ProductMapper productMapper;

    // save to database
    @Override
    public Product save(Product product) {
        String name = "%s %s".formatted(product.getPhoneModel().getName(), product.getColor().getColor_name());
        product.setName(name); 
        return productRepository.save(product);
    }

    //retreive by id
    @Override
    public Product getbyid(Long id) {
        return productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("id", id));
    }

    // retrieve all data from the table products
    @Override
    public List<Product> getallproducts() {
        return productRepository.findAll();
    }

    @Override
    public void importproduct(ProductImportDto productImportDto) {
        // update aviable products unit
        Product product = getbyid(productImportDto.getProductId());
        Integer avialableUnit = product.getAvailableUint() + productImportDto.getImportUnit();
        product.setAvailableUint(avialableUnit);
        productRepository.save(product);

        // save product import history 
        ProductImportHistory importHistory = productMapper.toProductImportHistory(productImportDto, product);
        productImportHistoryRepository.save(importHistory);
    }

    @Override
    public void SetPrice(PriceDto priceDto) {
       Product product = getbyid(priceDto.getId());
       product.setSalePrice(priceDto.getPrice());
       productRepository.save(product);
    }

    @Override
    public void uploadproduct(MultipartFile file) {

        try{
            Workbook workbook = new XSSFWorkbook(file.getInputStream());    
            Sheet sheet = workbook.getSheetAt(0);
            if(sheet == null){
                throw new RuntimeException("Sheet is not found in the file");
            }
            System.out.println("Name of Sheet: " + sheet.getSheetName());
            Iterator<Row> inIterator = sheet.iterator();
            while (inIterator.hasNext()) {
                Row row = inIterator.next();
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t\t");

                            Product product = getByModelIdAndColorId(null, null)

                            break;
                        default:
                            System.out.print("Unknown Type\t");
                            break;
                    }
                }
                System.out.println();
            }
        }
        catch(IOException e){
            System.out.println(e);
        }

      
    }

    @Override
    public Product getByModelIdAndColorId(Long modelId, Long colorId) {
        String test = "product with model id = %s and color id =%d was not found";
        return productRepository.findByModelIdAndColorId( modelId, colorId).orElseThrow(
            () -> new RuntimeException(HttpStatus.BAD_REQUEST, test.formatted(modelId, colorId));
        );
    }
    
}
