class FoodRatings {

    class FoodRating implements Comparable<FoodRating> {
        String name;
        String cuisine;
        int rating;

        public FoodRating(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }

        @Override
        public boolean equals(Object o) {
            FoodRating other = (FoodRating)(o);
            return Objects.equals(this.name, other.name);            
        }

        @Override
        public int compareTo(FoodRating other) {
            if (other.rating == this.rating) {
                return this.name.compareTo(other.name);
            }
            return other.rating - this.rating;
        }
    }
    Map<String, TreeSet<FoodRating>> cuisine;
    Map<String, FoodRating> foodRatings;


    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRatings = new HashMap<>();
        cuisine = new HashMap<>();

        for (int i = 0; i < foods.length; ++i) {
            FoodRating foodRating = new FoodRating(foods[i], cuisines[i], ratings[i]);
            
            foodRatings.put(foods[i], foodRating);
            cuisine.putIfAbsent(cuisines[i], new TreeSet<>());
            cuisine.get(cuisines[i]).add(foodRating);
        }
    }
    
    public void changeRating(String food, int newRating) {
        FoodRating foodRating = foodRatings.get(food);
        String cuisineName = foodRating.cuisine;
        cuisine.get(cuisineName).remove(foodRating);

        foodRating.rating = newRating;
        cuisine.get(cuisineName).add(foodRating);
        foodRatings.put(food, foodRating);
    }
    
    public String highestRated(String cuisineName) {
        return cuisine.get(cuisineName).first().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */