package com.blogwebsite.blog_wesite_apis.Exception;

public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException(String resourceName,String resourceField,long resourceValue) {
        super(String.format("%s not found with %s: %s",resourceName,resourceField,resourceValue));
    }
}
