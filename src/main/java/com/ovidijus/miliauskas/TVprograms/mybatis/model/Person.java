package com.ovidijus.miliauskas.TVprograms.mybatis.model;

public class Person {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PERSON.ID
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PERSON.USERNAME
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PERSON.PASSWORD
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    private String password;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PERSON.ID
     *
     * @return the value of PUBLIC.PERSON.ID
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PERSON.ID
     *
     * @param id the value for PUBLIC.PERSON.ID
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PERSON.USERNAME
     *
     * @return the value of PUBLIC.PERSON.USERNAME
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PERSON.USERNAME
     *
     * @param username the value for PUBLIC.PERSON.USERNAME
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PERSON.PASSWORD
     *
     * @return the value of PUBLIC.PERSON.PASSWORD
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PERSON.PASSWORD
     *
     * @param password the value for PUBLIC.PERSON.PASSWORD
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    public void setPassword(String password) {
        this.password = password;
    }
}