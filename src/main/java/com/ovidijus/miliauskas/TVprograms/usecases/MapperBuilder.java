package com.ovidijus.miliauskas.TVprograms.usecases;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MapperBuilder {
    public static <T> T buildMapper(Class<T> clazz) throws IOException {
        SqlSession session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("MyBatisConfig.xml")).openSession();
        return session.getMapper(clazz);
    }
}
