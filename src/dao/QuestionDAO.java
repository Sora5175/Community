package dao;

import java.util.List;

import entity.Answer;
import entity.Question;

public interface QuestionDAO extends GenericDAO<Question> {
	public void add(Question obj) throws Exception;
	public List<Question> search(String key) throws Exception;
}
