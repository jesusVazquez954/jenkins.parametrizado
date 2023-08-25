job('job-using-dsl') {
  
	description('Creating a job using a seed job D:')
	scm {
	git('https://github.com/macloujulian/jenkins.job.parametrizado.git', 'main') { node ->
	node / gitConfigName('Elliot')
		node / gitConfigEmail('elliot@fsociety.com')
		}
	}
 
    parameters {
	stringParam('nombre', defaultValue = 'Elliot', description = "Name of the person executing the job")
	choiceParam('Skills', ['Hacking', 'Programmer', 'Tester'])
	booleanParam('Beginner', false)
    }
  
  	triggers {
  		cron('H/7 * * * *') 
    }
  
    steps {
    	shell("bash jobscript.sh")
	shell("echo 'Hello world from console D:'")
    }
  
    publishers {
    	mailer('correoparavirus459@gmail.com', true, true);
    }
  
 
  
}
