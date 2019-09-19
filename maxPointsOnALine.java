/*
LC149
LC354


斜率 = b - y / a - x

先对a sort 求出所有比x 大的值， 再对b进行largest ascending subsequence，算出为正的，保证斜率为正

lc354
套信封也是这样，保证大信可以套小信，就必须信封右上角比前一个大，可以发散到斜率为正。

*/