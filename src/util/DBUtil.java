package util;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.*;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
    
	
	// 获得c3p0连接池对象
    private static ComboPooledDataSource ds = new ComboPooledDataSource();

    //获得数据库连接对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //获得c3p0连接池对象
    public static DataSource getDataSource() {
        return ds;
    }
    
    //关闭数据库连接
  	public static void close(Connection con){
  		try {
  			con.close();
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
  	}
  	
  	//获取queryrunner对象
  	public static QueryRunner getQueryRunner() {
  		return new QueryRunner(getDataSource());
  	}
  	
  	/**
  	 * 用于insert，update和delete
  	 * @param sql sql语句
  	 * @param params sql语句所需要的参数列表
  	 * @return 被修改的行数
  	 * @throws SQLException
  	 */
  	public static int changeTable(String sql,Object...params) throws SQLException {
  		QueryRunner qr = getQueryRunner();
  		return qr.update(sql, params);
  	}
  	
  	
  	/**
  	 * 
  	 * @param sql sql语句
  	 * @param handler 处理结果集的类，继承ResultSetHandler接口
  	 * @param params 参数列表
  	 * @return 被包装的结果集对象
  	 * @throws SQLException
  	 */
  	public static<T> T query(String sql,ResultSetHandler<T> handler,Object...params) throws SQLException{
  		QueryRunner qr = getQueryRunner();
  		T result=qr.query(sql, handler, params);
  		return result;
  	}
  	
  	/**
  	 * 
  	 * @param sql sql语句
  	 * @param type bean类型参数
  	 * @param params sql语句参数列表
  	 * @return bean对象列表
  	 * @throws SQLException
  	 */
	public static<T> List<T> queryBean(String sql,Class<T> type,Object...params) throws SQLException {
  		QueryRunner qr = getQueryRunner();
  		BeanListHandler<T> handler=new BeanListHandler<>(type);
  		return qr.query(sql, handler,params);
  	}
  	
	/**
	 * 分页方法
	 * @param tableName 表名
	 * @param id 列名，按此列名升序排序
	 * @param pageIndex 当前页
	 * @param size 页面大小
	 * @param type bean类型参数
	 * @return bean对象列表
	 * @throws SQLException
	 */
	public static<T> List<T> pageQuery(String tableName,String id,boolean asc,int pageIndex,int size,Class<T> type) throws SQLException{
		List<Object[]> list=query("select * from "+tableName, new ArrayListHandler(), new Object[] {});
		int tableSize=0;
		if(list!=null)
			tableSize=list.size();
		//派生表的大小
		int pageNum=(pageIndex-1)*size;
		int pageSize=((pageNum+size)>tableSize)?tableSize-pageNum:size;
		String rank = asc?"asc":"desc";
		//sql
		String sql="select * from "+tableName+" where IsExist = 1 order by "+id+" "+rank+" limit "+pageNum+","+pageSize;
		//查询
		return queryBean(sql, type, new Object[] {});
	}
	/*public static<T> List<T> pageQuery(String tableName,String id,int pageIndex,int size,Class<T> type) throws SQLException{
		List<Object[]> list=query("select * from "+tableName, new ArrayListHandler(), new Object[] {});
		int tableSize=0;
		if(list!=null)
			tableSize=list.size();
		//派生表的大小
		int count=((pageIndex*size)>tableSize)?tableSize:(pageIndex*size);
		//限定范围
		int limit=(pageIndex-1)*size;
		//sql
		String sql="select * from (select top "+count+" * from "+tableName+" where IsExist = 1 order by "+id+" asc) as dtable"+
		" where "+id+" not in(select top "+limit+" "+id+" from "+tableName+" where IsExist = 1 order by "+id+" asc)";
		//查询
		return queryBean(sql, type, new Object[] {});
	}*/
}