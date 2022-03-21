ARGS := time.nist.gov 13

compile: TCPAsk.java tcpclient/
	@docker run -itv $(PWD)/:/src/ --workdir=/src/ --rm openjdk:11-jdk-slim-buster javac TCPAsk.java

run: TCPAsk.java tcpclient
	@docker run -itv $(PWD)/:/src/ --workdir=/src/ --rm openjdk:11-jdk-slim-buster java TCPAsk $(ARGS)

delete: *.class tcpclient/*.class
	@rm -f *.class tcpclient/*.class
