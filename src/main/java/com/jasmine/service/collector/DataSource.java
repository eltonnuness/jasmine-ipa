package com.jasmine.service.collector;

import java.util.List;

import com.jasmine.exceptions.DataSourceException;
import com.jasmine.model.User;

public interface DataSource<E> {

	List<E> readTimeline(User user) throws DataSourceException;

}
