for (int i = 0; i < input.length(); i++) {
            if ((input.charAt(i) == ')' && tokens.peek() == '(')
                    || (input.charAt(i) == ']' && tokens.peek() == '[')
                    || (input.charAt(i) == '}' && tokens.peek() == '{')) {
                if (tokens.size() < 1) {
                    System.out.println("false");
                    return;
                } else {
                    tokens.pop();
                }
            } else {
                tokens.push(input.charAt(i));
            }
        }