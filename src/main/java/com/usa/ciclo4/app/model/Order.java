package com.usa.ciclo4.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.Map;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")

public class Order {

    public static String PENDING = "Pendiente";

    public static String APROVED = "Aprobada";

    public static String REJECTED = "Rechazada";

    @Id

    private Integer id;

    private Date registerDay;

    private String status;

    private User salesMan;

    private Map<Integer, Clone> products;

    private Map<Integer, Integer> quantities;
}
