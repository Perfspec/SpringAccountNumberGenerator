
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qa.business.service.AccountService;
import com.qa.business.service.IAccountService;
import com.qa.persistence.repository.AccountRepository;
import com.qa.persistence.repository.HibernateAccountRepositoryImpl;

public class Application {

	public static void main(String[] args) {
		
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		IAccountService service = appContext.getBean("accountService", AccountService.class);

		AccountRepository repo = new HibernateAccountRepositoryImpl();

		System.out.println(repo.createAccount("Andrew", "Knott", 6));
	}
}