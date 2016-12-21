package redis.redis;

import java.util.List;

import redis.clients.jedis.Jedis;

public class Redis {

	public static void main(String[] args) {
		try {
			System.out.println("Teste de conexão do Redis");

			// INSERINDO REGISTROS SIMPLES
			System.out.println("Inserindo dado");
			Jedis jedis = new Jedis("192.168.56.101");
			/*
			 * 		 
			jedis.set("foo", "bar");
			*/
			
			// INSERINDO VÁRIOS REGISTROS SIMPLES
			/*
			 * 			 
			for (int i=5000000; i<10000000; i++) {
				jedis.set("ABC-fooxxxxxxxxxxxxxxxxxxxxxxxxxx-fooxxxxxxxxxxxxxxxxxxxxxxxxxx-fooxxxxxxxxxxxxxxxxxxxxxxxxxx-fooxxxxxxxxxxxxxxxxxxxxxxxxxx-fooxxxxxxxxxxxxxxxxxxxxxxxxxx" + i, "bar-fooxxxxxxxxxxxxxxxxxxxxxxxxxx-fooxxxxxxxxxxxxxxxxxxxxxxxxxx-fooxxxxxxxxxxxxxxxxxxxxxxxxxx-fooxxxxxxxxxxxxxxxxxxxxxxxxxx-fooxxxxxxxxxxxxxxxxxxxxxxxxxx-fooxxxxxxxxxxxxxxxxxxxxxxxxxx" + i);			
			}
			*/
			
			System.out.println("Registro inserido com sucesso.");		

			System.out.println("Lendo dado");			
			String value = jedis.get("foo");
			System.out.println(value);	
			
			for (int i=1; i<5; i++) {
				String valuef = jedis.get("fooxxxxxxxxxxxxxxxxxxxxxxxxxx" + i);
				if (valuef == null) {
					System.out.println("Sem registro");	
				} else { 
					System.out.println(valuef);						
				}
			}
			System.out.println("Registro exibido com sucesso.");	
			
			/*
			 * 
			 
			// INSERINDO LISTAS
			jedis.lpush("tutorial-list", "Redis");
		    jedis.lpush("tutorial-list", "Mongodb");
		    jedis.lpush("tutorial-list", "Mysql");
		    jedis.lpush("tutorial-list", "Mysql");
		    
		    for (int g=0; g<1000; g++) {
		    	jedis.lpush("tutorial-list" + g, "Redis " + g);
			    jedis.lpush("tutorial-list" + g, "Mongodb " + g);
			    jedis.lpush("tutorial-list" + g, "Mysql " + g);
			    //jedis.lpush("tutorial-list" + g, "Mysql " + g);			    	
		    }
		    */
			
		    List<String> list = jedis.lrange("tutorial-list", 0 ,5);
		    for(int i=0; i<list.size(); i++) {
		      System.out.println("Stored string in redis:: "+list.get(i));
		    }
		    
		    for (int h =0; h<10; h++) {
			    List<String> list1 = jedis.lrange("tutorial-list" + h, 0 ,5);
			    for(int i=0; i<list1.size(); i++) {
			      System.out.println("Stored string in " + "tutorial-list" + h + " redis:: "+list1.get(i));
			    }		    	
		    }
		        
		    // EXIBINDO REGISTROS E LISTAS			
		    //List<String> lista = jedis.keys("*");
		    // for(int i=0; i<list.size(); i++) {
		    //   System.out.println("List of stored keys:: "+list.get(i));
		    // }
		     
		} catch (Exception e){
			System.out.println("Erro: " + e.getMessage());
		}		
 	}
}
