Problem 1: Given a mapping of digits to letters (as in a phone number), and a digit string, return all possible letters the number could represent. 
            You can assume each valid number in the mapping is a single digit.

          For example if {“2”: [“a”, “b”, “c”], 3: [“d”, “e”, “f”], …} then “23” should return [“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf"].
                                                                                        
                                                                                                
Solution : class Solution {
              public List<String> letterCombinations(String digits) {
                  List<String> combinations = new ArrayList<>();

                  if(digits.length() == 0)
                      return combinations;

                  Map<Character, String> keypad = new HashMap<>();

                  fillKeypad(keypad);

                  findCombinations(digits, keypad, "", 0, digits.length(), combinations);
                  System.out.println(combinations.size());
                  return combinations;
              }

              public void fillKeypad(Map<Character, String> keypad) {
                  keypad.put('2', "abc");
                  keypad.put('3', "def");
                  keypad.put('4', "ghi");
                  keypad.put('5', "jkl");
                  keypad.put('6', "mno");
                  keypad.put('7', "pqrs");
                  keypad.put('8', "tuv");
                  keypad.put('9', "wxyz");
              }

              public void findCombinations(String digits, Map<Character, String> keypad, String combination, 
                                              int i, int n, List<String> combinations) {
                  if(i == n) {
                      combinations.add(combination);
                      return;
                  }

                  String currentDigitMapping = keypad.get(digits.charAt(i));

                  for(int j = 0; j < currentDigitMapping.length(); j++)
                      findCombinations(digits, keypad, combination+currentDigitMapping.charAt(j), i+1, n,                                            combinations);
              }
          }
