package Infrastructure.Connection;

import java.sql.SQLException;
import java.sql.Connection;

public interface MyConnection {

	 /**
	  * Definition of the method that should be implemented in the classes that use this interface.
	  * @return  a connection to the database
	  * @throws SQLException an exception in case anything happens.
	  */
	 Connection connect() throws SQLException;

}
