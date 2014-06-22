package com.structurizr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Component extends Element {

    private Container parent;

    private String fullyQualifiedClassName;

    @JsonIgnore
    public Container getParent() {
        return parent;
    }

    public void setParent(Container parent) {
        this.parent = parent;
    }

    @Override
    public ElementType getType() {
        return ElementType.Component;
    }

    public String getFullyQualifiedClassName() {
        return fullyQualifiedClassName;
    }

    public void setFullyQualifiedClassName(String fullyQualifiedClassName) {
        this.fullyQualifiedClassName = fullyQualifiedClassName;
    }

    @Override
    public String getName() {
        if (this.fullyQualifiedClassName == null) {
            return super.getName();
        } else {
            return fullyQualifiedClassName.substring(fullyQualifiedClassName.lastIndexOf(".") + 1);
        }
    }

    @JsonIgnore
    public String getPackage() {
        return fullyQualifiedClassName.substring(0, fullyQualifiedClassName.lastIndexOf("."));
    }

    public void uses(Component destination, String description) {
        Relationship relationship = new Relationship(this, destination, description);
        relationships.add(relationship);
    }

}