package dao;

import java.util.List;

import entity.Answer;


public interface AnswerDAO extends GenericDAO<Answer> {
	public void add(Answer obj) throws Exception;
	public void up(Answer obj) throws Exception ;
	public void down(Answer obj) throws Exception ;
	public Answer find(String key) throws Exception;
	public List<Answer> findqa(String key) throws Exception;
}
