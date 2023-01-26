package com.example.demo.MyContoler;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ApiofMessage;
import com.example.demo.imple.UserServiceImple;
import com.example.demo.payload.UserDto;

@RestController
@RequestMapping("/user/")
public class Rest {
	
	@Autowired
	private UserServiceImple imple;
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> alluser(){
		List<UserDto> list = this.imple.getalluser();
		return  ResponseEntity.of(Optional.of(list));	
	}
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updating( @Valid@PathVariable int id,@RequestBody UserDto dto){
		UserDto dto2 = this.imple.update(dto, id);
		return ResponseEntity.ok(dto2);
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> byid(@PathVariable("id") int id){
		UserDto fn = this.imple.findingbyid(id);
	        return ResponseEntity.ok(fn);	
	}
	@PostMapping("/")
	public  ResponseEntity<UserDto>  cteating(@Valid @RequestBody UserDto dto){
		UserDto dto2 = this.imple.creatuser(dto);
		return ResponseEntity.ok(dto2);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiofMessage>  deleteing(@PathVariable("id") int id){
		this.imple.deleteuser(id);
		return  new ResponseEntity<ApiofMessage>(new ApiofMessage("Deleted succefully",false),HttpStatus.OK );
	}

	@DeleteMapping("/all")
	public ResponseEntity<UserDto> deletingall() {
		UserDto dto = this.imple.deleteingall();
		return  ResponseEntity.ok(dto);
	}
	
	
}
