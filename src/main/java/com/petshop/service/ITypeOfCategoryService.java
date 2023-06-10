package com.petshop.service;


import java.util.List;

import org.springframework.stereotype.Service;
import com.petshop.entity.TypeOfCategory;

@Service
public interface ITypeOfCategoryService {
	public List<TypeOfCategory> GetDataTypeOfCategoryList(String item_id);
	public List<TypeOfCategory> GetDataTypeOfCategory();	
	public List<TypeOfCategory> GetDataTypeOfCategory(String item_id);
	public int AddTypeOfCategory(TypeOfCategory typeOfCategory);
}
