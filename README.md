# Java Chatbot with GUI - Client-Server Architecture

A Java-based chatbot application featuring a graphical user interface with client-server architecture, utilizing an embedded H2 database for keyword-based responses.

## 🚀 Features

- **Client-Server Architecture**: Separate client and server components communicating via sockets
- **Graphical User Interface**: Swing-based chat interface for user interaction
- **Database-Driven Responses**: Keyword-based chatbot responses stored in H2 database
- **Embedded Database**: H2 database for easy deployment without external dependencies
- **Real-time Communication**: Socket-based communication between client and server
- **Multi-threaded Server**: Handles multiple client connections simultaneously

## 🛠️ Technologies Used

- **Java**: Core programming language
- **Swing**: GUI framework for the client interface
- **Socket Programming**: Network communication between client and server
- **H2 Database**: Embedded relational database for storing chatbot data
- **JDBC**: Database connectivity
- **Ant**: Build automation (NetBeans project structure)

## 📋 Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher
- **Java Runtime Environment (JRE)**: For running the compiled application
- **Operating System**: Windows, macOS, or Linux

## 🔧 Installation & Setup

### 1. Clone or Download the Project
```bash
# If using Git
git clone <repository-url>
cd Chatbot-Java-master
```

### 2. Project Structure
```
Chatbot-Java-master/
├── src/
│   ├── backend/
│   │   ├── Answer.java      # Chatbot response logic
│   │   └── DBHelper.java    # Database connection and operations
│   └── frontend/
│       ├── Client.java      # GUI client application
│       └── Server.java      # Server application
├── db_file/
│   └── chatbot_1.sql        # Database schema and sample data
├── lib/
│   └── h2-2.1.214.jar       # H2 database driver
├── build.xml                # Ant build configuration
├── manifest.mf              # JAR manifest
└── README.md               # This file
```

### 3. Database Setup
The application uses an embedded H2 database that is automatically created on first run. The database schema includes:

- **answer** table: Stores chatbot responses with categories
- **ask** table: Stores user input keywords mapped to categories

Sample data includes basic Indonesian greetings and responses.

## 🚀 Running the Application

### Method 1: Using Java Compiler (Recommended)

#### Compile the Project
```bash
# Create build directory if it doesn't exist
mkdir -p build/classes

# Compile all Java files
javac -cp "lib/h2-2.1.214.jar" -d build/classes src/**/*.java
```

#### Start the Server
```bash
java -cp "build/classes;lib/h2-2.1.214.jar" frontend.Server
```

#### Start the Client (in a new terminal)
```bash
java -cp "build/classes;lib/h2-2.1.214.jar" frontend.Client
```

### Method 2: Using Ant Build System
```bash
# Clean and build the project
ant clean
ant compile

# Run the server
ant -Dmain.class=frontend.Server run

# Run the client (in a new terminal)
ant -Dmain.class=frontend.Client run
```

## 💬 Usage

1. **Start the Server**: Run the server first to initialize the database and start listening for connections
2. **Launch the Client**: Open the client GUI application
3. **Chat Interface**:
   - Type your message in the text field at the bottom
   - Click "Send" button or press Enter to send
   - Chat history appears in the main text area
   - Type "/quit" to exit the application

### Sample Conversations
- User: "hai" → Bot: "hai juga"
- User: "apa kabar?" → Bot: "gimana kabarnya"
- User: "bye" → Bot: "bye!"

## 🗄️ Database Management

### Accessing H2 Console (Optional)
To view or modify the database directly:

```bash
java -jar lib/h2-2.1.214.jar
```

- **JDBC URL**: `jdbc:h2:./db_file/chatbot_1`
- **Username**: `sa`
- **Password**: (leave empty)

### Adding New Responses
To expand the chatbot's knowledge base, add entries to the `answer` and `ask` tables:

```sql
-- Add new response
INSERT INTO answer (answer, category) VALUES ('Your response here', 'category_name');

-- Add keyword mapping
INSERT INTO ask (ask, category) VALUES ('user_input', 'category_name');
```

## 🔧 Configuration

### Database Configuration
Located in `src/backend/DBHelper.java`:
- **Database URL**: `jdbc:h2:./db_file/chatbot_1`
- **Username**: `sa`
- **Password**: (empty)

### Server Configuration
Located in `src/frontend/Server.java`:
- **Port**: 1239 (default)
- **Host**: localhost (127.0.0.1)

## 🏗️ Architecture

### Client-Server Model
- **Server**: Manages database connections, processes user input, generates responses
- **Client**: Provides GUI interface, sends user messages, displays responses
- **Database**: Stores conversation patterns and responses

### Key Components
- **DBHelper.java**: Database connection and query execution
- **Answer.java**: Business logic for response generation
- **Server.java**: Socket server handling multiple clients
- **Client.java**: Swing GUI for user interaction

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Areas for Improvement
- Add more conversation data to the database
- Implement conversation history persistence
- Add user authentication
- Enhance the GUI design
- Implement natural language processing

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.



## 🙏 Acknowledgments

- Built as a learning project for Java socket programming
- Uses H2 database for embedded database functionality
- Inspired by basic chatbot implementations

---

**Note**: This is a basic implementation intended for educational purposes. The chatbot has limited responses and would benefit from additional training data for more comprehensive conversations.
