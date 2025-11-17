FROM ubuntu:24.04

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && apt-get install -y \
    git \
    git-lfs \
    openjdk-21-jdk \
    maven \
    mysql-server \
    && rm -rf /var/lib/apt/lists/*

RUN echo "CREATE USER 'ecommerceAdmin'@'localhost' IDENTIFIED BY 'Ecommerce123!@'; \
        GRANT ALL PRIVILEGES ON *.* TO 'ecommerceAdmin'@'localhost' WITH GRANT OPTION; \
        CREATE DATABASE ecommerce; \
        FLUSH PRIVILEGES;" > /tmp/script.sql

RUN service mysql start && \
    sleep 5 && \
    mysql -uroot < /tmp/script.sql && \
    service mysql stop

WORKDIR /workspace

CMD [ "bash" ]