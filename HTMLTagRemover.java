public class HTMLTagRemover {

    public static String removeTag(String input) {
        // Check if the string starts with an opening tag
        if (input.startsWith("<") && input.contains(">")) {
            // Find the position of the first closing bracket '>'
            int closingBracketIndex = input.indexOf('>');
            
            // Extract the tag name (between '<' and '>')
            String tagName = input.substring(1, closingBracketIndex);
            
            // Construct the closing tag
            String closingTag = "</" + tagName + ">";
            
            // Check if the string ends with the corresponding closing tag
            if (input.endsWith(closingTag)) {
                // Remove the opening and closing tags and return the content in between
                return input.substring(closingBracketIndex + 1, input.length() - closingTag.length());
            }
        }
        
        // If the conditions are not met, return the original string
        return input;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(removeTag("<b>Strings are immutable</b>"));  // Should return "Strings are immutable"
        System.out.println(removeTag("<p>This is a paragraph</p>"));    // Should return "This is a paragraph"
        System.out.println(removeTag("No tags here"));                  // Should return "No tags here"
        System.out.println(removeTag("<a href='#'>Link</a>"));          // Should return "Link"
        System.out.println(removeTag("<div>Content</span>"));           // Should return "<div>Content</span>"
    }
}
