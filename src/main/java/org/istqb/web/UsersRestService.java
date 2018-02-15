package org.istqb.web;

import java.util.List;

import org.istqb.entities.Users;
import org.istqb.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class UsersRestService {
	@Autowired
private UsersRepository usersRepository;
	
	@Secured(value= {"ROLE_ADMIN"})
	@RequestMapping(value="/saveUsers",method=RequestMethod.POST)
	public Users save(@RequestBody Users c){
		return usersRepository.save(c);
			
	}
	@Secured(value= {"ROLE_ADMIN","ROLE_MANAGER"})
		@RequestMapping(value="/list",method=RequestMethod.GET)
	public Page<Users> listUsers(int page,int size){
		return usersRepository.findAll(new PageRequest(page, size));
			
	}
		@RequestMapping(value="/list/{id}",method=RequestMethod.GET)
		public Users getUsers(@PathVariable Integer id){
			return usersRepository.findOne(id);
}
		
		@RequestMapping(value="/list/{id}",method=RequestMethod.DELETE)
		public boolean delete(@PathVariable Integer id){
			usersRepository.delete(id);
			return true ;
				
		}
		@RequestMapping(value="/list/{id}",method=RequestMethod.PUT)
		public Users save(@PathVariable int id,@RequestBody Users c){
			c.setId(id);
			return usersRepository.save(c);
}
		@RequestMapping(value="/fetch_Users",method=RequestMethod.GET)
		public Page<Users> fetch(
			                   @RequestParam(name="page",defaultValue="0")int page,
				                   @RequestParam(name="size",defaultValue="5")int size){
		return usersRepository.fetch(new PageRequest(page, size));
}
}