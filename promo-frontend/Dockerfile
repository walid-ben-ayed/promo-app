FROM ghcr.io/cirruslabs/flutter:stable
WORKDIR /app
COPY . .
RUN flutter pub get
EXPOSE 8081
CMD ["flutter", "run", "-d", "web-server", "--web-port", "8081", "--web-hostname", "0.0.0.0"]
