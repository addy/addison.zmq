java_library(
  name = "jeromq",
  exports = [
    "@maven//:org_zeromq_jeromq"
  ],
)

java_binary(
  name = "Server",
  srcs = ["src/main/java/addison/addison/zmq/Server.java"],
  deps = [":jeromq"],
)

java_binary(
  name = "Client",
  srcs = glob(["src/main/java/addison/addison/zmq/Client*.java"]),
  deps = [":jeromq"],
)