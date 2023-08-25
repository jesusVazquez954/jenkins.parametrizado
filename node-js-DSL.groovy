job('nodejs application DSL') {
    description('Creating an application using node.js and jenkins with help of groovy')

    scm {
        git('https://github.com/macloujulian/nodejsapp.git', 'master') { node -> 
            node / gitConfigName('Elliot')
            node / gitCongifEmail('elliot@fsociety.com')
        }
    }

    triggers {
        scm('H/7 * * * *')
    }

    wrappers {
        nodejs('NodeJs-14.11.0')
    }

    steps {
        shell('echo "========EXECUTING PROCESS========')
        shell('npm install')
    }
}
