package mburakaltun.Northwind.entities.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoryDTO {
    private int id;
    private String productName;
    private String categoryName;
}
