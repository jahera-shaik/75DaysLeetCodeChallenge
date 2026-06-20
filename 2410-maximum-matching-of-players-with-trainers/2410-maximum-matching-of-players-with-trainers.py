class Solution:
    def matchPlayersAndTrainers(self, players: List[int], trainers: List[int]) -> int:
        players = sorted(players)
        trainers = sorted(trainers)
        count = 0                                          
        for trainer in trainers:                           
            if count < len(players) and trainer >= players[count]:
                count = count + 1
        return count