class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        return asteroidCollisionStack(asteroids);
    }

    public int[] asteroidCollisionStack(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            //if the current asteroid is moving in the negative direction, check what previous asteroids it destroys
            while(!(stack.isEmpty()) && asteroid < 0 && stack.peek() > 0) {
                int impact = asteroid + stack.peek();
                //if the current negative moving asteroid wins
                if (impact < 0) {
                    //remove the asteroid on the top of the stack
                    stack.pop();
                }
                //if the current negative moving asteroid loses out to the previous asteroid
                else if (impact > 0) {
                    //turn the current asteroid to dust and keep the stack intact
                    asteroid = 0;
                } 
                //if the current negative moving asteroid has the same size as the previous asteroid
                else {
                    //obliterate both asteroids by converting current value to 0 and removing the previous asteroid
                    stack.pop();
                    asteroid = 0;
                }
            }
            //add the asteroid to stack if not obliterated
            if (asteroid != 0) {
                stack.push(asteroid);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
            }
        return result;
    }
}