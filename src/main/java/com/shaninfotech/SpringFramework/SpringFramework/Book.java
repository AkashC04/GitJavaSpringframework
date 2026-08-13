package com.shaninfotech.SpringFramework.SpringFramework;

import org.springframework.stereotype.Component;

@Component
public class Book {
        private Author author;

		public Book(Author author) {
			super();
			this.author = author;
		}
        public void bookDetails() {
        	author.authorDetails();
        	System.out.println("book name is java 9");
        }
        
        	
        
}
