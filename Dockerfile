# Use the official OpenJDK image
FROM openjdk:21

# Set working directory inside the container
WORKDIR /app

# Copy everything from your local project to /app in the container
COPY . /app

# Create bin directory for compiled classes
RUN mkdir -p bin

# Compile all Java files
RUN javac -cp "lib/*" -d bin src/edu/pi/simulation/*.java

# Command to run your program
CMD ["java", "-cp", "bin:lib/*", "edu.pi.simulation.Main"]
