package com.narendra.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class WebClientController {
	
	@Autowired
	WebClient wc;
	
	@GetMapping("/get-query-param")
	public String getMappingQueryParam(@RequestParam("request-param") String queryParam) {
		return wc.get().uri("http://localhost:9999/input-controller/get-query-param?request-param=qwertyum").retrieve().toEntity(String.class).block().getBody(); 
	}

	
	@PostMapping(value="/post/{path-variable}",consumes ={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}) 
	  public String postMapping(@PathVariable("path-variable") String pathVariable,@RequestParam("request-param") String queryParam,@RequestBody Student str)
	  {
		return wc.post().uri("http://localhost:9999/input-controller/post/postMethod?request-param=qqq").bodyValue(str).retrieve().toEntity(String.class).block().getBody(); 

	  }
	 
	
	@DeleteMapping("/delete/{path-variable}")
	public String deleteMapping(@PathVariable("path-variable") String pathVariable,@RequestParam("request-param") String queryParam)
	{
		return wc.delete().uri("http://localhost:9999/input-controller/delete/dltMethod?request-param=qqq").retrieve().toEntity(String.class).block().getBody(); 

	}
	
	

}
