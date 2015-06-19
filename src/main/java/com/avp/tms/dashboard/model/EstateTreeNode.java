/**
 * Copyright (c) 2015 All Rights Reserved, ROAM Data, Inc.
 */
package com.avp.tms.dashboard.model;

import java.io.Serializable;
import java.util.ArrayList;


public class EstateTreeNode implements Serializable{


private static final long serialVersionUID = 7601313975673096253L;

private String id; 
private ArrayList<EstateTreeNode> children;
private String text;
private boolean hasChildren;
private String classes;
private boolean enabled;
private boolean isexpand;
private boolean complete;
private boolean expanded;
private String custom1;

public String getCustom1() {
return custom1;
}

public void setCustom1(String custom1) {
this.custom1 = custom1;
}

public String getId(){
return id;
}

public void setId(String value){
this.id = value;
}

public Boolean getEnabled(){
return enabled;
}

public void setEnabled(boolean value){
this.enabled = value;
}

public String getClasses(){
return classes;
}

public void setClasses(String value){
this.classes = value;
}

public String getText(){
return text;
}

public void setText(String value){
this.text = value;
}

public boolean getHasChildren(){
return hasChildren;
}


public void setHasChildren(boolean value){
this.hasChildren = value;
}

public void setExpanded(boolean value){
this.expanded = value;
}

public boolean getExpanded(){
return expanded;
}

public void setIsexpand(boolean value){
this.isexpand = value;
}

public boolean getIsexpand(){
return isexpand;
}

public void setComplete(boolean value){
this.complete = value;
}

public boolean getComplete(){
return complete;
}

public ArrayList<EstateTreeNode> getChildren(){
return children;
}

public void setChildren(ArrayList<EstateTreeNode> value){
this.children = value;
}

}
