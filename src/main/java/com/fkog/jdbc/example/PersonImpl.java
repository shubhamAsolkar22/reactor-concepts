package com.fkog.jdbc.example;

import java.util.Objects;

public class PersonImpl implements Person {
	private int id;
    private String name;

    public PersonImpl(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
	public int getId() {
        return id;
    }

    @Override
	public void setId(int id) {
        this.id = id;
    }

    @Override
	public String getName() {
        return name;
    }

    @Override
	public void setName(String name) {
        this.name = name;
    }

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonImpl other = (PersonImpl) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

    
}
