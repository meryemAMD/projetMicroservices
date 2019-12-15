package org.sid.entities;




import java.util.ArrayList;
import java.util.Collection;

import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Document
@Data @AllArgsConstructor @NoArgsConstructor 

public class AppRole {
    @Id
    private String id;
    private String roleName;
/*    
    @DBRef
    private Collection<AppUser> users=new ArrayList<>();*/
 
	public AppRole(String id, String roleName, Collection<AppUser> users) {
		super();
		this.id = id;
		this.roleName = roleName;
	}



	public AppRole() {
		super();
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}









    
}
