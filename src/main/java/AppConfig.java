import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qa.business.service.AccountService;
import com.qa.business.service.IPrizeGenerator;
import com.qa.business.service.PrizeGenerator;
import com.qa.persistence.repository.AccountRepository;
import com.qa.persistence.repository.HibernateAccountRepositoryImpl;

@Configuration
public class AppConfig {

	@Bean(name = "accountService")
	public AccountService accountService() {
		AccountService service = new AccountService();
		service.setAccountRepo(getAccountRepository());
		service.setPrizeGenerator(getPrizeGenerator());
		return service;
	}

	@Bean(name = "accountRepository")
	public AccountRepository getAccountRepository() {
		return new HibernateAccountRepositoryImpl();
	}

	@Bean(name = "prizeGenerator")
	public IPrizeGenerator getPrizeGenerator() {
		return new PrizeGenerator();
	}

}
