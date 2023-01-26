package com.example.demo.MyContoler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.imple.MyCatogoryimple;
import com.example.demo.payload.CatogryDto;

@RestController
@RequestMapping("/catogray/")
public class MyRestContolerForCatogory {

	@Autowired
	private MyCatogoryimple catogoryimple;
	
	

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/")
	public ResponseEntity<CatogryDto> creatingg(@Valid @RequestBody CatogryDto dto) {
		return ResponseEntity.ok(this.catogoryimple.createing(dto));
	}

	@ResponseStatus(value = HttpStatus.OK)
    @PutMapping("/{id}")
     public ResponseEntity<CatogryDto> update(@Valid @RequestBody CatogryDto dto,@PathVariable("id") Integer id) {
       	CatogryDto dto2 = this.catogoryimple.updateing(dto, id);
      return ResponseEntity.ok(dto2);
 }
	@ResponseStatus(value = HttpStatus.OK)
      @GetMapping("/")
       public ResponseEntity<List<CatogryDto>> all() {
    	   
    	   List<CatogryDto> get = this.catogoryimple.getallobject();
    	   
    	   return ResponseEntity.ok(get) ;
       }
	@ResponseStatus(value = HttpStatus.OK)
      @GetMapping("/{id}")
       public ResponseEntity<CatogryDto>  getby(@PathVariable("id") Integer id) {
    	   CatogryDto dto = this.catogoryimple.getbyid(id);
    	   return ResponseEntity.ok(dto);
    	   
       }
      @DeleteMapping("/{id}")
     public ResponseEntity<?> byiddele(@PathVariable("id") Integer id)
     {
             this.catogoryimple.deletingobjectbyid(id);
      return ResponseEntity.ok(HttpStatus.OK);
   }


}




