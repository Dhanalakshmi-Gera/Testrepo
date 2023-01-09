package com.example.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;


@RestController
public class SupplyController {
	@PostMapping("/updateSupply")
	@ResponseBody
	public String updateSupply(@RequestBody String body) {
		Date convertedDatetime1 = Date.from(LocalDateTime.parse("2021-03-16T08:53:48.616Z",DateTimeFormatter.ISO_DATE_TIME).atZone(ZoneId.systemDefault()).toInstant());
		Date convertedDatetime2 =Date.from(LocalDateTime.parse("2021-03-16T08:59:48.616Z",DateTimeFormatter.ISO_DATE_TIME).atZone(ZoneId.systemDefault()).toInstant());
		Date convertedDatetime3=Date.from(LocalDateTime.parse("2021-03-16T09:10:48.616Z",DateTimeFormatter.ISO_DATE_TIME).atZone(ZoneId.systemDefault()).toInstant());
		Date convertedDatetime4=Date.from(LocalDateTime.parse("2021-03-16T09:10:48.616Z",DateTimeFormatter.ISO_DATE_TIME).atZone(ZoneId.systemDefault()).toInstant());
		List<Object> demanSupList = Arrays.asList(
				new Supply("Product1",convertedDatetime1,10d),
				new Supply ("Product2",convertedDatetime2,5d),
				new Supply ("Product3",convertedDatetime3,30d),
				new Supply ("Product4",convertedDatetime4,20d));
		Map<String, String> hashMap = new Gson().fromJson(body, Map.class);
		
		Object value = demanSupList.stream().filter(elem ->((String)hashMap.get("productId")).equals(((Supply)elem).getProductId())).findAny().get();
		if(value !=null) {
			Supply s = (Supply)value;
			LocalDateTime supDate =LocalDateTime.ofInstant(s.getUpdateTimeStamp().toInstant(), ZoneId.systemDefault());
			if(LocalDateTime.parse((String)hashMap.get("updateTimeStamp")).isBefore(supDate)) {
				return "{\"productId\":\""+hashMap.get("productId")+"\",\"updateTimeStamp\":\""+s.getUpdateTimeStamp()+"\",\"quantity\":"+s.getQuantity()+",\r\n" + 
						"\"status\": \"Out Of Sync Update\"}";
			} else {
				return "{\"productId\": "+hashMap.get("productId")+", \"updateTimeStamp\":"+s.getUpdateTimeStamp()+", \"quantity\": "+(s.getQuantity()+Double.valueOf(hashMap.get("quantity")))+", \"status\": \"Updated\"}";
			}
			
		}
		else return "No data match";
	}

}
