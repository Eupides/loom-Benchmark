FROM ubuntu
RUN mkdir "/tmp/loomTests/"
RUN mkdir "/tmp/loomTests/tests/"
COPY ./build/libs/*.jar /tmp/loomTests/

RUN apt-get update && \
    apt-get install -y openjdk-19-jdk && \
    apt-get clean;

# Fix certificate issues
RUN apt-get update && \
    apt-get install ca-certificates-java && \
    apt-get clean && \
    update-ca-certificates -f;

# Setup JAVA_HOME -- useful for docker commandline
ENV JAVA_HOME /usr/lib/jvm/java-19-openjdk-amd64/
RUN export JAVA_HOME