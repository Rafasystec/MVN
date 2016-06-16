package br.com.barcadero.rule;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Classe utilizada para agendar tarefas a serem feitas no sistema.
 * @author rafael
 * @since versao 1.0 Beta dia 03/12/2013 as 21:57
 */

public class FacadeAgendamento {
	
	//private static int count = 0;
	
	public void executaTarefaPeriodica() {
		//Ideal para quando quereos que um determinada tarefa se repita em determinado periodo de tempo.
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Chama tarefa.");
				timer.cancel();
			}
		}, 5000, 3000);
	}
	
	public void tarefaPontual() {
		Calendar data = Calendar.getInstance();
		//O segundo parametro eh o mes comecando em 0(janeiro) e indo ate 11(dezembro)
		data.set(2011, 4, 30);
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Executando tarefa pontual. Com data prevista para:" );
			}
		}, data.getTime());
	}
	
	public void tarefaPorHoraMarcada() {
		Calendar data = Calendar.getInstance();
		data.set(Calendar.HOUR_OF_DAY,23);
		data.set(Calendar.MINUTE,0);
		data.set(Calendar.SECOND, 0);
		
		Date time = data.getTime();
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Executou a tarefa previnsta para as 23:00. Com hora marcada.");
				timer.cancel();
			}
		}, time);
	}
	
	public void tarefaComDataEHora() {
		Calendar data = Calendar.getInstance();
		data.set(2013,11,3);
		data.set(Calendar.HOUR_OF_DAY,22);
		data.set(Calendar.MINUTE,55);
		data.set(Calendar.SECOND, 0);
		Date time = data.getTime();
		
		final Timer timer= new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Backup do banco agendado para excutar as 22:55");
				System.out.println("Iniciando backp do banco de dados aguarde....");
				backup();
				System.out.println("Fim de backup. Continuação das outras atividades.");
				System.out.println("Saindo.");
				timer.cancel();
			}
		}, time);
	}
	
	public void tarefaPorDiaPorMes() {
		Calendar data = Calendar.getInstance();
		data.set(Calendar.DAY_OF_MONTH,5);
		Date time = data.getTime();
		
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Executou tarefa prevista para o dia 4");
			}
		}, time);
	}
	
	public void backup() {
		for(int i = 0 ; i < 1000000; i++){
			for (int j = 0; j < 1000; j++) {
				
			}
		}
		System.out.println("Executou o backp");
	}
}
