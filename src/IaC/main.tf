provider "aws" {
  region = "us-east-1"
}

resource "aws_security_group" "spring_sg" {
  name        = "spring-dev-sg"
  description = "Allow SSH and App Port"

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 8080
    to_port     = 8080
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_instance" "spring_dev" {
  ami                         = "ami-0c02fb55956c7d316"  # Amazon Linux 2
  instance_type               = "t2.micro"
  key_name                    = "/Users/chandan/projects/techeazy/TechEazyBootcamp.pem"  #Use existing AWS key pair name
  vpc_security_group_ids      = [aws_security_group.spring_sg.id]

  user_data = <<-EOF
              #!/bin/bash
              sudo yum update -y
              sudo yum install -y java-17-amazon-corretto
              mkdir -p /home/ec2-user/traffic-monitor
              chown ec2-user:ec2-user /home/ec2-user/traffic-monitor
              EOF

  tags = {
    Name = "spring-dev-env"
  }
}
