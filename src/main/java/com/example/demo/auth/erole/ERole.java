package com.example.demo.auth.erole;

public enum ERole
{
    ADMIN("ROLE_ADMIN"), GUEST("ROLE_GUEST");

    private String value;

    private ERole ( final String value )
    {
        this.setValue ( value );
    }

    public String getValue ()
    {
        return this.value;
    }

    public void setValue ( final String value )
    {
        this.value = value;
    }

}
