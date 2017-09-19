PQ Kernel implementation in Java. For Matlab or C/C++ version check: http://pq-kernel.herokuapp.com/ 


If you use this software (or a modified version of it) in any scientific work, please cite the corresponding paper:
```
Radu T. Ionescu, Marius Popescu. PQ kernel: a rank correlation kernel for visual word histograms. Pattern Recognition Letters, vol. 55, pp. 51-57, 2015. [BibTeX]
```
The PQ kernel treats the histograms of visual words as ordinal data, in which data is ordered but cannot be assumed to have equal distance between values. In this case, a histogram will be interpreted as a ranking of visual words according to their frequencies in that histogram.

Usage of the ranks of visual words instead of the actual values of the frequencies may seem as a loss of information, but the process of ranking can actually make PQ more robust, acting as a filter and eliminating the noise contained in the values of the frequencies.

The PQ kernel is roughly 2% better than state of the art kernels, such as the intersection kernel or the Jenson-Shannon kernel, on the Pascal VOC data set.