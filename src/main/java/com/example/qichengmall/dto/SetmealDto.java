package com.example.qichengmall.dto;

import com.example.qichengmall.entity.Setmeal;
import com.example.qichengmall.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
