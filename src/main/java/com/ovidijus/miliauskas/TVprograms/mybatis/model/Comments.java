package com.ovidijus.miliauskas.TVprograms.mybatis.model;

public class Comments {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMMENTS.ID
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMMENTS.PERSONID
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    private Integer personid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMMENTS.TVPROGRAMID
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    private Integer tvprogramid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMMENTS.TEXT
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    private String text;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMMENTS.ID
     *
     * @return the value of PUBLIC.COMMENTS.ID
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMMENTS.ID
     *
     * @param id the value for PUBLIC.COMMENTS.ID
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMMENTS.PERSONID
     *
     * @return the value of PUBLIC.COMMENTS.PERSONID
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    public Integer getPersonid() {
        return personid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMMENTS.PERSONID
     *
     * @param personid the value for PUBLIC.COMMENTS.PERSONID
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMMENTS.TVPROGRAMID
     *
     * @return the value of PUBLIC.COMMENTS.TVPROGRAMID
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    public Integer getTvprogramid() {
        return tvprogramid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMMENTS.TVPROGRAMID
     *
     * @param tvprogramid the value for PUBLIC.COMMENTS.TVPROGRAMID
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    public void setTvprogramid(Integer tvprogramid) {
        this.tvprogramid = tvprogramid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMMENTS.TEXT
     *
     * @return the value of PUBLIC.COMMENTS.TEXT
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    public String getText() {
        return text;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMMENTS.TEXT
     *
     * @param text the value for PUBLIC.COMMENTS.TEXT
     *
     * @mbg.generated Tue Apr 27 21:03:02 EEST 2021
     */
    public void setText(String text) {
        this.text = text;
    }
}