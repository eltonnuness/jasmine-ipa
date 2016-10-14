package com.jasmine.service.collector;

import com.jasmine.model.User;

/**
 * Classe abstrata que define quais são as operações disponiveis pelos
 * Collectors(Coletores).
 * 
 * @author Élton Nunes - <elton_12_nunes@hotmail.com>
 * @since 14/10/2016
 */
public abstract class Collector {

	protected boolean running;

	protected abstract void startCollectService(User user);

	protected abstract void stopCollectService(User user);
}
