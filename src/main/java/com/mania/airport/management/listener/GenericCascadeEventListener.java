package com.mania.airport.management.listener;

import java.lang.annotation.Annotation;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.mongodb.DBRef;

@Component
public class GenericCascadeEventListener extends AbstractMongoEventListener<Object>{
	private MongoTemplate mongoTemplate;
	
	public GenericCascadeEventListener(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public void onBeforeConvert(BeforeConvertEvent<Object> event) {
		Object document = event.getSource();
		
		ReflectionUtils.doWithFields(document.getClass(), docField -> {
			ReflectionUtils.makeAccessible(docField);
			
			if(docField.isAnnotationPresent((Class<? extends Annotation>) DBRef.class))
			{
				final Object fieldValue = docField.get(document);
				// Save child
				this.mongoTemplate.save(fieldValue);
			}
		});
	}
}
