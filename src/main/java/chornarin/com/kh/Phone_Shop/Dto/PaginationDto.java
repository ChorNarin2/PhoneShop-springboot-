package chornarin.com.kh.Phone_Shop.Dto;

import lombok.Data;

@Data
public class PaginationDto {

    private int pageNumber;
    private int pageSize;
    private int totalElements;
    private int totalPages;
    private long numberOfElements;

    private boolean first;
    private boolean last;
    private boolean empty;


}


// {
//     "content": [
//         {
//             "id": 4,
//             "name": "chichi"
//         }
//     ],
//     "pageable": {
//         "pageNumber": 0,
//         "pageSize": 1,
//         "sort": {
//             "empty": true,
//             "sorted": false,
//             "unsorted": true
//         },
//         "offset": 0,
//         "paged": true,
//         "unpaged": false
//     },
//     "last": false,
//     "totalElements": 3,
//     "totalPages": 3,
//     "size": 1,
//     "number": 0,
//     "sort": {
//         "empty": true,
//         "sorted": false,
//         "unsorted": true
//     },
//     "first": true,
//     "numberOfElements": 1,
//     "empty": false
// }