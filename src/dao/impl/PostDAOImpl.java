package dao.impl;

import java.util.List;

import dao.PostDAO;
import entity.Post;

import util.DBUtil;

public class PostDAOImpl implements PostDAO {

	@Override
	public List<Post> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Post where IsExist = 1";
		return DBUtil.queryBean(sql, Post.class, new Object[] {});
	}

	@Override
	public Post find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Post where IsExist = 1 and PNo = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Post.class, params).size()==0?null:DBUtil.queryBean(sql, Post.class, params).get(0);
	}

	@Override
	public void add(Post obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into Post (PNo,Content,Photo,PublisherNo,PublisherTime,IsExist) values(?,?,?,?,?,?)";
		Object[] params= {obj.getpNo(),obj.getContent(),obj.getPhoto(),obj.getPublisherNo(),obj.getPublisherTime(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(Post obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Post set Content = ? , Photo = ? , PublisherNo = ? , PublisherTime = ? , IsExist = ? where PNo = ?";
		Object[] params= {obj.getContent(),obj.getPhoto(),obj.getPublisherNo(),obj.getPublisherTime(),obj.getIsExist(),obj.getpNo()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Post set IsExist = 0 where PNo = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<Post> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("Post", "PNo", true, pageIndex, size, Post.class);
	}

}
