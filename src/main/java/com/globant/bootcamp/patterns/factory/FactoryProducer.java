package com.globant.bootcamp.patterns.factory;

import com.globant.bootcamp.repository.DBType;

public class FactoryProducer {
    
   public static ConnectionAbstractFactory getFactory(Enum<DBType> choice){
      if(choice.equals(DBType.MYSQL)){
         return new SqlConnectionFactory();
         
      }else if(choice.equals(DBType.POSTGRES)){
         return new PostgresConnectionFactory();
      }
      
      return null;
   }
}

