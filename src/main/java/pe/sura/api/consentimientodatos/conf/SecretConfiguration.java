package pe.sura.api.consentimientodatos.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import pe.sura.api.consentimientodatos.util.SecretParameter;

@Component
public class SecretConfiguration {
	
	private static final Logger logger = LoggerFactory.getLogger(SecretConfiguration.class);
	
	@Autowired
	SecretBean property;
	
	public SecretParameter getSecretKey() {
		AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard()
				.withRegion(property.getRegion())
				.build();
		GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest().withSecretId(property.getSecretname());
		GetSecretValueResult getSecretValueResult = client.getSecretValue(getSecretValueRequest);
		String secretString = getSecretValueResult.getSecretString();
		
		SecretParameter secretParameter = null;
		try {
			logger.info(String.format("secretString %s", secretString));
			secretParameter = new ObjectMapper().readValue(secretString, SecretParameter.class);
		} catch (Exception e) {
			e.getMessage();
		}
		return secretParameter;
	}

}
