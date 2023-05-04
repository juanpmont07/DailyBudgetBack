FROM postgres

ENV POSTGRES_USER admin
ENV POSTGRES_PASSWORD admin_budget
ENV POSTGRES_DB DailyBudget

COPY src/main/resources/daily_budget.sql /docker-entrypoint-initdb.d/

EXPOSE 5432